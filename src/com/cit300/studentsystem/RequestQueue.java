package com.cit300.studentsystem;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private Queue<String> requests;

    public RequestQueue() {
        requests = new LinkedList<>();
    }


    public void addRequest(String studentId, String requestDetails) {
        String request = "Student " + studentId + " - " + requestDetails;
        requests.add(request);
        System.out.println("Request added: " + request);
    }


    public String processNextRequest() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return null;
        }
        String processed = requests.poll();
        System.out.println("Processed: " + processed);
        return processed;
    }


    public void displayRequests() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        System.out.println("---- Pending Service Requests ----");
        for (String req : requests) {
            System.out.println(req);
        }
    }

    public boolean isEmpty() {
        return requests.isEmpty();
    }

    public int getSize() {
        return requests.size();
    }
}