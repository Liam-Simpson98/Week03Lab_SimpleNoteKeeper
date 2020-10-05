package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String path = this.getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader buff = new BufferedReader(new FileReader(new File(path)));
        String title = buff.readLine();
        String contents = buff.readLine();
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        String edit = request.getParameter("editNote");
        
        if (edit == null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
        } else {
        
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            
        }
        
        
        buff.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String path = this.getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        writer.write(title + "\n" + contents);
        //writer.write(contents);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        
        writer.close();
    }
}
