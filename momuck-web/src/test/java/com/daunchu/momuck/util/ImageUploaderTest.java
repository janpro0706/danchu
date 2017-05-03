package com.daunchu.momuck.util;

import com.danchu.momuck.util.MomuckImageUploader;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by geine on 2017. 5. 1..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:/root-context.xml", "classpath:servlet-context.xml"})
public class ImageUploaderTest {

    @Autowired
    private MomuckImageUploader momuckImageUploader;

    private static final Logger LOG = LoggerFactory.getLogger(ImageUploaderTest.class);


    @Test
    public void uploadAndDeleteImage() throws IOException {

        HttpServletRequest request = new MockMultipartHttpServletRequest();

        //여기 냄새남..ㅠㅠ
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fis = classloader.getResourceAsStream("static/TestImage.jpeg");
        byte[] testImageBytes = IOUtils.toByteArray(fis);
        MockMultipartFile testFile = new MockMultipartFile("image", "", "application/json", testImageBytes);

        request.setAttribute("image", testFile);

        File image = momuckImageUploader.uploadImage(request);
        assertThat(image.canRead(), is(true));

        momuckImageUploader.deleteImage(image.getName());
        assertThat(image.exists(), is(false));
    }
}
