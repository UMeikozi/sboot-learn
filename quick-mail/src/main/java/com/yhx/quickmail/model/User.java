package com.yhx.quickmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

/**
 * @author: shipeng.yu
 * @time: 2016年10月03日 上午10:02
 * @version: 1.0
 * @since: 1.0
 * @description:
 */
//@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotEmpty
    @Column(nullable = false)
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能小于6位")
    @Column(nullable = false)
    private String password;

    @Email(regexp = "^\\w+@[0-9a-zA-Z_]+?\\.[a-zA-Z]{2,5}$", message = "邮箱格式不正确")
    private String email;
}
