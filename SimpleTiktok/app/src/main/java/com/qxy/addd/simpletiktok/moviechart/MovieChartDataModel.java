package com.qxy.addd.simpletiktok.net;

import java.io.Serializable;
import java.util.List;

public class MovieChartDataModel implements Serializable {

    private List<SubjectsBean> subjects;

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean{
        /**
         * "actors": [
         *           "[徐峥 袁泉 沈腾 吴云芳 陈奇 黄梅莹 欧丽娅 贾冰 郭京飞]"
         *         ],
         *         "areas": [
         *           "[中国]"
         *         ],
         *         "directors": [
         *           "[徐峥]"
         *         ],
         *         "discussion_hot": "789200",
         *         "hot": "1.361e+06",
         *         "id": "6399487713065566465",
         *         "influence_hot": "789200",
         *         "maoyan_id": "1250696",
         *         "name": "囧妈",
         *         "name_en": "Lost in Russia",
         *         "poster": "https://p3-dy.bytecdn.cn/obj/compass/9ac412ae054b57f69c0967a8eb5e25c9",
         *         "release_date": "2020-01-25",
         *         "search_hot": "684900",
         *         "tags": [
         *           "[喜剧]"
         *         ],
         *         "topic_hot": "684900",
         *         "type": "1"
         */
        private String poster;
        private String name;
        private String discussion_hot;
        private String[] actors;
        private String release_date;

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        private String[] tags;

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDiscussion_hot() {
            return discussion_hot;
        }

        public void setDiscussion_hot(String discussion_hot) {
            this.discussion_hot = discussion_hot;
        }

        public String[] getActors() {
            return actors;
        }

        public void setActors(String[] actors) {
            this.actors = actors;
        }

        public String[] getTags() {
            return tags;
        }

        public void setTags(String[] tags) {
            this.tags = tags;
        }
    }




}
