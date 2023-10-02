package study.datajpa.entity;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {

//    @Value("#{target.username + ' ' + target.age}") //open projections
    String getUsername();
}
