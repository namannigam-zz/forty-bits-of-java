package com.stackoverflow.nullpointer.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class WebServer extends Thread {

    private static final String CONNECTION_ID = "connid";
    private static final String TIMEOUT = "timeout";

    /**
     * This method is invoked on HTTP GET/sleep?timeout=20&connid=1
     *
     * @param paramMap
     * @param clientSocket
     * You can use the following method to write to a socket -
     *
     *                     PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
     *                     <p>
     *                     You need to write to the output after the specified "timeout" amount of seconds.
     *                     <p>
     *                     You will need to close the clientSocket in order to respond to the client
     *                     <p>
     *                     NOTE - Your implementation needs to be able to handle multiple client connecting simultaneously.
     */
    private void implementSleepRequest(Map<String, String> paramMap, Socket clientSocket) {
        /*
		 * You need to Retrieve connid and timeout from paramsMap and implement
		 * the jdk.handling for the GET /sleep method
		 */

        // Your code goes here.
        Long timeout = Long.parseLong(paramMap.get(TIMEOUT)) * 1000;
        String connectionId = paramMap.get(CONNECTION_ID);
        try {
            clientSocket = new Socket(connectionId, 8080);
            sleep(timeout);
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            output.write("stat: ok");
            clientSocket.close();
        } catch (InterruptedException | IOException e) {
            System.out.println("Exception - " + e.getMessage());
        }
    }


    /**
     * This method is called when the request is GET/server-status
     * <p>
     * Returns the status of all the connections currently connected and their
     * time left to sleep
     *
     * @param clientSocket
     */
    //
    public void implementGetServerStatusRequest(Socket clientSocket) {

        // Your code goes here.

    }

    /**
     * This method is called when the request is POST /kill
     * <p>
     * Kills a given connection id
     *
     * @param requestBody
     * @param clientSocket
     */
    private void implementKillConnectionRequest(String requestBody, Socket clientSocket) {
		/*
		 * You need to retrieve connid from the requestBody and kill the
		 * corresponding connection.
		 */

        // Your code goes here.
        String connectionId = requestBody.trim().split("=")[requestBody.trim().split("=").length - 1];
        try {
            clientSocket = new Socket(connectionId, 8080);
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Exception - " + e.getMessage());
        }
    }

    private void callMethod(WebServerRequestBody webServerRequestBody, Socket clientSocket) {
        if (WebServerUtils.isPostRequest(webServerRequestBody)) {
            if (webServerRequestBody.getRequestUri() != null && webServerRequestBody.getRequestUri().contains("kill")) {
                implementKillConnectionRequest(webServerRequestBody.getRequestBody(), clientSocket);
            }
        } else if (WebServerUtils.isGetRequest(webServerRequestBody)) {
            if (webServerRequestBody.getRequestUri() != null
                    && webServerRequestBody.getRequestUri().contains("sleep")) {
                implementSleepRequest(webServerRequestBody.getRequestParams(), clientSocket);
            } else if (webServerRequestBody.getRequestUri() != null
                    && webServerRequestBody.getRequestUri().contains("server-status")) {
                implementGetServerStatusRequest(clientSocket);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer();
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        while (true) {
            // Create the Web server
            // Parse the Web request and populate the WebServerRequestBody
            // object
			/*
			 * WebServerRequestBody.java is present in the same folder which
			 * getter methods for the following attributes
			 * private String method;
			 * private Map<String, String> requestParams;
			 * private String requestBody;
			 * private String requestUri;
			 *
			 */

            Socket clientSocket = server.accept();
            InputStream input = clientSocket.getInputStream();
            WebServerRequestBody webServerRequestBody = WebServerUtils.parseRequest(input);

            // Handle the Web request
            webServer.callMethod(webServerRequestBody, clientSocket);
        }

    }
}