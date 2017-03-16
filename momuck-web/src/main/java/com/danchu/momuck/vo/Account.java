package com.danchu.momuck.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Account
 *
 * @author geine
 */
public class Account {

    @JsonProperty("seq_account")
    private int seqAccount;

    /**
     * @TODO 에러 메세지 한글로 변경 필요, 인코딩 세팅
     */
    @Pattern(regexp = "^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$", message = "not email")
    private String email;

    private String password;

    @Size(min = 4, max = 45, message = "name is 4 to 45")
    private String name;

    @JsonProperty("profile_image")
    private String profileImage;

    @Max(value = 3, message = "not allow type")
    @Min(value = 1, message = "not allow type")
    @JsonProperty("account_type")
    private int accountType;

    @JsonProperty("is_facebook")
    private int isFacebook;

    @JsonProperty("is_kakao")
    private int isKakao;

    @JsonProperty("is_verify")
    private int isVerify;

    private Date created;

    public int getSeqAccount() {
        return seqAccount;
    }

    public void setSeqAccount(int seqAccount) {
        this.seqAccount = seqAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int isFacebook() {
        return isFacebook;
    }

    public void setFacebook(int facebook) {
        isFacebook = facebook;
    }

    public int isKakao() {
        return isKakao;
    }

    public void setKakao(int kakao) {
        isKakao = kakao;
    }

    public int isVerify() {
        return isVerify;
    }

    public void setVerify(int verify) {
        isVerify = verify;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Account{" +
                "seqAccount=" + seqAccount +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", accountType=" + accountType +
                ", isFacebook=" + isFacebook +
                ", isKakao=" + isKakao +
                ", isVerify=" + isVerify +
                ", created=" + created +
                '}';
    }
}
