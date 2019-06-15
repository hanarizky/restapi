package com.doku.demo.restapi;

import com.doku.demo.restapi.model.UserDetailsRequest;
import com.doku.demo.restapi.dto.UserRest;
import com.doku.demo.restapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RestapiApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void createUser() {
        UserDetailsRequest user = new UserDetailsRequest();
        user.setUserId("1");
        user.setFullName("Hana");
        user.setUserName("hanarizky");
        user.setEmail("hana@mail.com");

        log.info("-------- Parameter that we POST --------");
        log.info("userId="+user.getUserId());
        log.info("fullName="+user.getFullName());
        log.info("userName="+user.getUserName());
        log.info("email="+user.getEmail());


        UserRest create = userService.createUser(user);

        assertThat(create.getUserId()).isEqualTo(user.getUserId());
        assertThat(create.getFullName()).isEqualTo(user.getFullName());
        assertThat(create.getUserName()).isEqualTo(user.getUserName());
        assertThat(create.getEmail()).isEqualTo(user.getEmail());

        log.info("----------- Posted Parameter -----------");
        log.info(create.toString());

    }

    @Test
    public void getUser() {

        createUser();
        log.info("");

        String userId  = "1";
        log.info("GET userId=1");

        UserRest result = userService.getUser(userId);
        assertThat(result.getFullName()).isEqualTo("Hana");
        assertThat(result.getUserName()).isEqualTo("hanarizky");
        assertThat(result.getEmail()).isEqualTo("hana@mail.com");

        log.info("-------- Parameter that we GET --------");
        log.info(result.toString());
    }

}
