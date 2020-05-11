package net.kuper.tz.apitool.service;

import net.kuper.tz.apitool.entity.BMapIPLocation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BMapService {
    /**
     * @param ak   您的AK
     * @param ip   您的IP
     * @param coor coor不出现、或为空：百度墨卡托坐标，即百度米制坐标
     *             coor = bd09ll：百度经纬度坐标，在国测局坐标基础之上二次加密而来
     *             coor = gcj02：国测局02坐标，在原始GPS坐标基础上，按照国家测绘行业统一要求，加密后的坐标
     * @return
     */
    @GET("/location/ip")
    Call<BMapIPLocation> getIpLocation(@Query("ak") String ak, @Query("ip") String ip, @Query("coor") String coor);
}
