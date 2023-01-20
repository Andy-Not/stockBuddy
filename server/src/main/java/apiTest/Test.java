package apiTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author joandy alejo garcia
 */
public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String[] stocks = {"AAPL", "TSLA"};
         getStocks(stocks);
    }
    private static void getStocks(String[] stocks) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.stockdata.org/v1/data/quote?symbols=AAPL,TSLA,MSFT&api_token=fRdzKtx9NKXHLMP02PN3xzzfWBh6sX421EjXvYA4"))
                .build();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());
    }
}
