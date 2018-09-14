package com.stasRevin.greetingTagHandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class GreetingTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();
        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour();
        MonthDay groundhogDay = MonthDay.of(2, 2);

        if (currentHour > 0 && currentHour < 12) {

            out.println("Good morning!");

        } else if (currentHour >= 12 && currentHour < 18) {

            out.println("Good afternoon!");

        } else if (currentHour >= 18 && (currentHour <= 23 || currentHour == 0)) {

            out.println("Good evening!");

        }

        if (now.getMonthValue() == groundhogDay.getMonthValue()) {

            out.println("Happy Groundhog Day!");
        }


    }
}
