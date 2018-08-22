package com.santech.hongbao.app.list;


/**
 * Desc: 列表请求的页码管理类
 * <p>
 * Author: QiuRonaC
 * Date: 2018-07-09
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 */
public class PageIndicator {
    /**
     * 默认每页30个
     */
    public final static int PAGE_PER_SIZE = 30;
    public static final int START = 0;
    private int curPage;

    PageIndicator() {
        firstPage();
    }

    void nextPage() {
        curPage++;
    }

    int getCurPage() {
        return curPage;
    }

    void firstPage() {
        curPage = START;
    }
}
