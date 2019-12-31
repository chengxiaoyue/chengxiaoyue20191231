package com.bawei.chengxiaoyue20191231.bean;

import java.util.List;

/**
 * date:2019/12/31
 * author:程小越
 * function:
 */
public class UserBean {

    private List<RankingBean> ranking;

    public List<RankingBean> getRanking() {
        return ranking;
    }

    public void setRanking(List<RankingBean> ranking) {
        this.ranking = ranking;
    }

    public static class RankingBean {
        /**
         * avatar : http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg
         * name : Alice
         * rank : 1
         */

        private String avatar;
        private String name;
        private String rank;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }
    }
}
