package hiki;

import java.util.*;

public class User {
    private final String name;
    private final String gender;

    // 可选属性，默认值为-1
    private final int age;
    private final int height;
    private final int weight;

    private User(Builder builder) {
        if (builder.name == null || builder.name.trim().isEmpty()) {
            throw new IllegalArgumentException("姓名必须设置");
        }
        if (builder.gender == null || builder.gender.trim().isEmpty()) {
            throw new IllegalArgumentException("性别必须设置");
        }
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static class Builder {
        private String name;
        private String gender;
        private int age = -1;
        private int height = -1;
        private int weight = -1;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder height(int height) {
            this.height = height;
            return this;
        }
        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
    // Getter方法
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        User user1 = new Builder().name("zhangsan").gender("male").build();
    }
}

