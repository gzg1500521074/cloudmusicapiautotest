package com.cloudmusic.testcase;

import com.cloudmusic.apibusiness.LoginBusiness;
import com.cloudmusic.apibusiness.VideoDetailBussiness;
import org.testng.annotations.Test;

public class TestVideo {

    VideoDetailBussiness video = new VideoDetailBussiness();

    @Test
    public void testVideo(){
        video.getVideoDetailBussiness();
    }
}
