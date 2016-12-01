package com.bwf.aiyiqi.framwork.tool;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface Contact {

    //listView  Recycleview  ---所有adapterview 底部的三种状态
    //fial: -1  Loading: 0  nomoredata： 1

    int FOOTER_STATUE_FAIL = -1;
    int FOOTER_STATUE_LOADING = 0;
    int FOOTER_STATUE_NOMOREDATA = 1;
    //装修学堂最上面的17个标签
    String tab[]={"验房收房","装修公司","量房设计","辅材选购","主材选购","家居选购","装修合同","主体拆迁",
            "水电改造","防水处理","木土工程","瓦工工程","油工工程","主材安装","竣工验收","软装配饰","居家生活"};

}
