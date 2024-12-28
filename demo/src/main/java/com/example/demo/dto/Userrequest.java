package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Userrequest {
    Long userId;
    Long courseId;
    String fullName;
    String contactInfo;
    String email;

    public static Userrequest fromEntity(User user, Long courseId) {
        return new Userrequest(
                user.getUserId(),
                courseId,
                user.getUsername(),
                user.getContactInfo(),
                user.getEmail()
        );
    }

    public Userrequest(Long userId, Long courseId, String fullName, String contactInfo, String email) {
        this.userId = userId;
        this.courseId = courseId;
        this.fullName = fullName;
        this.contactInfo = contactInfo;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
