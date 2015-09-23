package com.shanks.map;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

public class MainActivity extends Activity implements AMapLocationListener {

    private LocationManagerProxy mLocationManagerProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity_main);
        mLocationManagerProxy = LocationManagerProxy.getInstance(this);
        mLocationManagerProxy.requestLocationData(
                LocationProviderProxy.AMapNetwork, 10 * 1000, 1, this);
        mLocationManagerProxy.setGpsEnable(false);
    }


    public void show(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
           show(aMapLocation.getSpeed()+"");
/*        if(aMapLocation != null && aMapLocation.getAMapException().getErrorCode() == 0){
            //获取位置信息
            Double geoLat = aMapLocation.getLatitude();
            Double geoLng = aMapLocation.getLongitude();
            Toast.makeText(this, "onLocationChanged-location"+geoLat+":"+geoLng, Toast.LENGTH_SHORT).show();

        }*/
/*
        String desc = "";
        Bundle locBundle = aMapLocation.getExtras();
        if (locBundle != null) {
            desc = locBundle.getString("desc");
            //Toast.makeText(this, "onLocationChanged-location"+desc, Toast.LENGTH_SHORT).show();
        }else{
           // Toast.makeText(this, "onLocationChanged-location"+aMapLocation.getProvider(), Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onLocationChanged(Location location) {
        String desc = "";
        Bundle locBundle = location.getExtras();
        if (locBundle != null) {
            desc = locBundle.getString("desc");
            Toast.makeText(this, "onLocationChanged-location"+desc, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "onLocationChanged-location"+location.getProvider(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Toast.makeText(this, "onStatusChanged", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(this, "onProviderEnabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(this, "onProviderDisabled", Toast.LENGTH_SHORT).show();
    }
}
