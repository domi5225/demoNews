package control;

import java.io.IOException;

import dao.DAO;
import entity.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet(name = "PostControl", urlPatterns = {"/post/*"})
public class PostControl extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("post servlet");
        String slug = request.getPathInfo();
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        if(slug != null && slug.length()>1){
            String id = slug.substring(slug.lastIndexOf("-")+1);
            DAO dao = new DAO();
            Post post = dao.getPostByID(id);
            if(post != null){
                request.setAttribute("p", post);
                request.getRequestDispatcher("/post.jsp").forward(request,response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
    
}
