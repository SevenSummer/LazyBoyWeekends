package lazyboyweekends.wuhao.example.com.lazyboyweekends_wuhao.JavaBean_Module;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Activity_Info {
    /**
     * biz_phone :
     * address : 武汉市武昌区和平大道三角路水岸国际LOFT公寓805
     * show_free : true
     * want_status : 0
     * poi : 初见花园咖啡
     * category : DIY手作
     * collected_num : 2
     * title : 亲手做健康的月饼送给家人吧！
     * leo_id : 1358311203
     * sell_status : 2
     * front_cover_image_list : ["http://image.lanrenzhoumo.com/leo/img/20160823210412_5a8e428a2db494299cbd7219affb93ef.JPG","http://image.lanrenzhoumo.com/leo/img/20160823210414_e24c1338347dc5cfcb8d5eb650efec62.JPG","http://image.lanrenzhoumo.com/leo/img/20160823210413_0c57f227fdff5b784eab2ce91f79a4a6.JPG","http://image.lanrenzhoumo.com/leo/img/20160823210414_0e82f75698943d41561a8efe749218aa.JPG"]
     * viewed_num : 79
     * consult_phone :
     * jump_type : leo_detail_api
     * tags : ["亲子","情侣","单身"]
     * price : 88.0
     * time_info : 截止至9月15日
     * time_desc : 8月24日 11:00 ~ 9月15日 20:00
     * jump_data :
     * distance : 868
     * item_type : leo
     * time : {"start":"2016-08-24 11:00:00","end":"2016-09-15 20:00:00"}
     * price_info : 88
     * category_id : 9
     * poi_name : 初见花园咖啡
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String address;
        private String poi;
        private String category;
        private int collected_num;
        private String title;
        private int leo_id;
        private double price;
        private String time_info;
        private String time_desc;
        private int distance;
        private List<String> front_cover_image_list;

        public ResultBean(String address, String category, int collected_num, int distance, List<String> front_cover_image_list, int leo_id, String poi, double price,  String time_desc, String time_info, String title) {
            this.address = address;
            this.category = category;
            this.collected_num = collected_num;
            this.distance = distance;
            this.front_cover_image_list = front_cover_image_list;
            this.leo_id = leo_id;
            this.poi = poi;
            this.price = price;
            this.time_desc = time_desc;
            this.time_info = time_info;
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPoi() {
            return poi;
        }

        public void setPoi(String poi) {
            this.poi = poi;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getCollected_num() {
            return collected_num;
        }

        public void setCollected_num(int collected_num) {
            this.collected_num = collected_num;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getLeo_id() {
            return leo_id;
        }

        public void setLeo_id(int leo_id) {
            this.leo_id = leo_id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getTime_info() {
            return time_info;
        }

        public void setTime_info(String time_info) {
            this.time_info = time_info;
        }

        public String getTime_desc() {
            return time_desc;
        }

        public void setTime_desc(String time_desc) {
            this.time_desc = time_desc;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }


        public List<String> getFront_cover_image_list() {
            return front_cover_image_list;
        }

        public void setFront_cover_image_list(List<String> front_cover_image_list) {
            this.front_cover_image_list = front_cover_image_list;
        }
    }
}
