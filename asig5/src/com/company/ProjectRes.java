package com.company;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProjectRes implements InterfaceProjectRes {
    private final InterfaceDB db;

    public ProjectRes(InterfaceDB db) {
        this.db = db;
    }

    @Override
    public boolean createProject(Project project) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO projects(name,totalCost) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, project.getName());
            st.setInt(2, project.getTotalCost());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Project getProject(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,totalCost FROM projects WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Project project = new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                return project;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,totalCost FROM projects";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Project> projects = new LinkedList<>();
            while (rs.next()) {
                Project project = new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                projects.add(project);
            }

            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
