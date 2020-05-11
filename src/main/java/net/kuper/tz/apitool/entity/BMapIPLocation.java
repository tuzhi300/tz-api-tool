package net.kuper.tz.apitool.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BMapIPLocation {
    /**
     * address : CN|北京|北京|None|CHINANET|1|None
     * content : {"address":"北京市","address_detail":{"city":"北京市","city_code":131,"district":"","province":"北京市"},"point":{"x":"116.39564504","y":"39.92998578"}}
     * status : 0
     */

    @JsonProperty("address")
    private String address;
    @JsonProperty("content")
    private ContentBean content;
    @JsonProperty("status")
    private int status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContentBean {
        /**
         * address : 北京市
         * address_detail : {"city":"北京市","city_code":131,"district":"","province":"北京市"}
         * point : {"x":"116.39564504","y":"39.92998578"}
         */

        @JsonProperty("address")
        private String address;
        @JsonProperty("address_detail")
        private AddressDetailBean addressDetail;
        @JsonProperty("point")
        private PointBean point;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressDetailBean getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(AddressDetailBean addressDetail) {
            this.addressDetail = addressDetail;
        }

        public PointBean getPoint() {
            return point;
        }

        public void setPoint(PointBean point) {
            this.point = point;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AddressDetailBean {
            /**
             * city : 北京市
             * city_code : 131
             * district :
             * province : 北京市
             */

            @JsonProperty("city")
            private String city;
            @JsonProperty("city_code")
            private String cityCode;
            @JsonProperty("district")
            private String district;
            @JsonProperty("province")
            private String province;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCityCode() {
                return cityCode;
            }

            public void setCityCode(String cityCode) {
                this.cityCode = cityCode;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }
        }

        public static class PointBean {
            /**
             * x : 116.39564504
             * y : 39.92998578
             */

            @JsonProperty("x")
            private String x;
            @JsonProperty("y")
            private String y;

            public String getX() {
                return x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y;
            }

            public void setY(String y) {
                this.y = y;
            }
        }
    }
}
