package com.spring.learn_servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.spring.learn_servlet.DatasInfor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tablesBundleServlets")
public class TablesBundleServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DatasInfor datasInfor = new DatasInfor();

        // // Title
        // HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        // // 테이블 값 for문
        // ArrayList<String> tablesListWithString =
        // datasInfor.getTablesListWithString();

        // 통합부분
        HashMap<String, Object> bundlesData = datasInfor.getBundlesData();
        // 오브젝트면 오류가 남 cast 필수
        HashMap<String, String> searchForm = (HashMap<String, String>) bundlesData.get("searchForm");
        ArrayList<String> tablesListWithString = (ArrayList<String>) bundlesData.get("tablesListWithString");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("        <!DOCTYPE html>");
        printWriter.println("        <html lang='en'>");
        printWriter.println("  <head>");
        printWriter.println("    <meta charset='UTF-8' />");
        printWriter.println("    <title>" + searchForm.get("search_key") + "</title>");
        printWriter.println("    <link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("    <link");
        printWriter.println("      href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("      rel='stylesheet'");
        printWriter
                .println("      integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("      crossorigin='anonymous'");
        printWriter.println("    />");
        printWriter.println("  </head>");

        printWriter.println("  <body>");
        printWriter.println("    <div class='container'>");
        printWriter.println("      <div class='fs-3'>Tables Normal with Bundles data</div>");
        printWriter.println("      <table class='table'>");
        printWriter.println("        <thead>");
        printWriter.println("          <tr>");
        printWriter.println("            <th scope=''>#</th>");
        // printWriter.println(" <th scope=''>First</th>");
        // printWriter.println(" <th scope=''>Last</th>");
        printWriter.println("            <th scope=''>Handle</th>");
        printWriter.println("         </tr>");
        printWriter.println("        </thead>");
        printWriter.println("        <tbody>");
        for (int i = 0; i < tablesListWithString.size(); i++) {
            printWriter.println("          <tr>");
            printWriter.println("            <th scope=''>" + (i + 1) + "</th>");
            String handle = tablesListWithString.get(i);
            printWriter.println("            <td>" + handle + "</td>");
            printWriter.println("          </tr>");

        }

        printWriter.println("        </tbody>");
        printWriter.println("     </table>");
        printWriter.println("    </div>");
        printWriter.println("    <script");
        printWriter.println("      src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter
                .println("      integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("     crossorigin='anonymous'");
        printWriter.println("    ></script>");
        printWriter.println("  </body>");
        printWriter.println("</html>");

        printWriter.close();
    }

}
