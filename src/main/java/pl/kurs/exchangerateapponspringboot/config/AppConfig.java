package pl.kurs.exchangerateapponspringboot.config;

public interface    AppConfig {
    //https://api.fastforex.io/fetch-all?from=USD&api_key=5b1a77668c-fcdaf4a550-rtmhuz
    String FASTFOREX_API_PAGE = "https://api.fastforex.io";
    String ENDPOINT = "/fetch-all?from=";
    String API_KEY = "&api_key=d13db615a9-2b21d2fb4d-rxfem8";
}
