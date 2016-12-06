package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.framwork.tool.UriUtils;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bobo on 2016/11/23.
 */
public class ScanActivity extends BaseActivity {
    @BindView(R.id.test)
    ImageView test;
    private CaptureFragment scanFragment;

    @Override
    protected void initDatas() {
    }
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_scan;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        scanFragment = (CaptureFragment) getSupportFragmentManager().findFragmentById(R.id.scan_fragment);
        scanFragment.setAnalyzeCallback(new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(ScanActivity.this, "结果为：" + result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(ScanActivity.this, "扫描失败", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean isFlash;

    @OnClick({R.id.scan_photo, R.id.scan_file, R.id.scan_led})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_photo:
                //跳转到系统相机
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 0);
                }
                break;
            case R.id.scan_file:
                //调到系统相册，
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
                break;
            case R.id.scan_led:
                //开启闪光灯
                isFlash = !isFlash;
                CodeUtils.isLightEnable(isFlash);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap mBitmap = null;
        if (requestCode == 0 && data != null) {
            Uri uri = data.getData();
            String path = UriUtils.uri2PathFile(this, uri);
            Bundle extras = data.getExtras();
            if (extras != null) {
                mBitmap = (Bitmap) extras.get("data");
                path = saveBitmap(mBitmap);
            }
            //获得uri后交给Zxing二维码解释
            //如果mBitmap 为空 则会采取path去找图片，如果不为空就以mBitmap去解析
            Log.d("ScanActivity", "mBitmap:" + mBitmap);
            Log.d("ScanActivity", "path:" + path);

            test.setImageBitmap(mBitmap);

            CodeUtils.analyzeBitmap(path,new CodeUtils.AnalyzeCallback() {
                @Override
                public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                    Toast.makeText(ScanActivity.this, "结果为：" + result, Toast.LENGTH_SHORT).show();
                    finish();
                }
                @Override
                public void onAnalyzeFailed() {
                    Toast.makeText(ScanActivity.this, "扫描失败", Toast.LENGTH_SHORT).show();
//                    finish();
                }
            });
        }
    }


    public String saveBitmap(Bitmap bitmap){
        File file = new File("/storage/sdcard0/UCDownloads/"+ System.currentTimeMillis()+".png");
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getPath();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        CodeUtils.isLightEnable(false);
    }
}
