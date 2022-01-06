package jp.gr.java_conf.simpleblogapi.presentation;

public class SecurityConstants {

    public static final String SECRET = "hoge"; // TODO: 管理方法を検討
    public static final long EXPIRATION_TIME = 28_800_000;
    public static final String LOGIN_API_URL = "/api/user/login";

    public static final String[] NO_AUTHORIZATION_REQUIRED_GET_URLS = {
            "/api/article",
            "/api/article/*",
            "/api/category",
            "/file/*"};

    public static final String[] NO_AUTHORIZATION_REQUIRED_POST_URLS = {
            LOGIN_API_URL,
            "/api/user/signup"};
}
