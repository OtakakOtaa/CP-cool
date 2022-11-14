package org.example.Client.View.ImGUI;

import imgui.ImGui;
import imgui.type.ImDouble;
import imgui.type.ImInt;
import imgui.type.ImString;
import org.example.Core.Entities.Student;
import org.example.UI.Layer;
import org.example.UI.UIProvider;

import java.math.BigDecimal;
import java.sql.Date;

public class ImGUIApplicationLayer extends Layer {

    private boolean isButtonInsertClick = false;

    private Student InputStudent;

    private UIProvider uiProvider;

    private final String insertButtonTitle = "Add Student";
    private int itemWidth = 100;

    private ImString imFname = new ImString(20);
    private ImString imLname = new ImString(20);
    private ImString imAddress = new ImString(20);
    private ImString imNumber = new ImString(20);
    private ImString imMail = new ImString(20);
    private ImString imCity = new ImString(20);
    private ImString imDesignation = new ImString(20);
    private ImDouble imSalary = new ImDouble();
    private ImInt imDobYear = new ImInt();
    private ImInt imDobMonth = new ImInt();
    private ImInt imDobDay = new ImInt();
    private ImInt imDojYear = new ImInt();
    private ImInt imDojMonth = new ImInt();
    private ImInt imDojDay = new ImInt();

    public ImGUIApplicationLayer(UIProvider uiProvider) {
        this.uiProvider = uiProvider;
    }

    @Override
    public void layer() throws Exception {
        ImGui.begin("application window");

        insertButton();

        ImGui.end();
    }

    private void insertButton() throws Exception {

        if (ImGui.button(insertButtonTitle, 500, 500)) {
            isButtonInsertClick = true;
        }

        if (isButtonInsertClick) {
            ImGui.begin("Student form");

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" F. Name", imFname);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" L. Name", imLname);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" Address", imAddress);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" Mobile Number", imNumber);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" Mail", imMail);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" City", imCity);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputText(" Designation", imDesignation);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth * 3);
            ImGui.inputDouble(" Salary", imSalary);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Dob year", imDobYear);

            ImGui.sameLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Dob month", imDobMonth);

            ImGui.sameLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Dob day", imDobDay);


            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Doj year", imDojYear);

            ImGui.sameLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Doj month", imDojMonth);

            ImGui.sameLine();
            ImGui.setNextItemWidth(itemWidth);
            ImGui.inputInt(" Doj day", imDojDay);

            ImGui.newLine();
            ImGui.setNextItemWidth(itemWidth);

            if (ImGui.button("Insert")) { uiProvider.insertStudent(CreateStudent()); }
            ImGui.end();
        }
    }

    private Student CreateStudent() {
        return  new Student(
                imFname.get(),
                imLname.get(),
                imAddress.get(),
                imNumber.get(),
                imMail.get(),
                imCity.get(),
                imDesignation.get(),
                new Date(imDobYear.get(), imDobMonth.get(), imDobDay.get()),
                new Date(imDojYear.get(), imDojMonth.get(), imDojDay.get()),
                new BigDecimal(imSalary.get())
        );
    }
}
