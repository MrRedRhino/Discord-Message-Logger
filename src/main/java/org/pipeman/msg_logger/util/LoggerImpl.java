//
// Source code recreated from a .class file by Quiltflower
//

package org.pipeman.msg_logger.util;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerImpl implements Logger {

    public String getName() {
        return "Default Logger";
    }

    public boolean isTraceEnabled() {
        return false;
    }

    public void trace(String s) {
    }

    public void trace(String s, Object o) {
    }

    public void trace(String s, Object o, Object o1) {
    }

    public void trace(String s, Object... objects) {
    }

    public void trace(String s, Throwable throwable) {
    }

    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    public void trace(Marker marker, String s) {
    }

    public void trace(Marker marker, String s, Object o) {
    }

    public void trace(Marker marker, String s, Object o, Object o1) {
    }

    public void trace(Marker marker, String s, Object... objects) {
    }

    public void trace(Marker marker, String s, Throwable throwable) {
    }

    public boolean isDebugEnabled() {
        return false;
    }

    public void debug(String s) {
    }

    public void debug(String s, Object o) {
    }

    public void debug(String s, Object o, Object o1) {
    }

    public void debug(String s, Object... objects) {
    }

    public void debug(String s, Throwable throwable) {
    }

    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    public void debug(Marker marker, String s) {
    }

    public void debug(Marker marker, String s, Object o) {
    }

    public void debug(Marker marker, String s, Object o, Object o1) {
    }

    public void debug(Marker marker, String s, Object... objects) {
    }

    public void debug(Marker marker, String s, Throwable throwable) {
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public void info(String s) {
        System.out.println("[INFO] " + formatTime() + s);
    }

    public void info(String s, Object o) {
        System.out.println("[INFO] " + this.formatMessage(s, o));
    }

    public void info(String s, Object o, Object o1) {
        System.out.println("[INFO] " + this.formatMessage(s, o, o1));
    }

    public void info(String s, Object... objects) {
        System.out.println("[INFO] " + this.formatMessage(s, objects));
    }

    public void info(String s, Throwable throwable) {
        System.out.println("[INFO] " + this.formatMessage(s, throwable));
    }

    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    public void info(Marker marker, String s) {
        System.out.println("[INFO] " + formatTime() + s);
    }

    public void info(Marker marker, String s, Object o) {
        System.out.println("[INFO] " + this.formatMessage(s, o));
    }

    public void info(Marker marker, String s, Object o, Object o1) {
        System.out.println("[INFO] " + this.formatMessage(s, o, o1));
    }

    public void info(Marker marker, String s, Object... objects) {
        System.out.println("[INFO] " + this.formatMessage(s, objects));
    }

    public void info(Marker marker, String s, Throwable throwable) {
        System.out.println("[INFO] " + this.formatMessage(s, throwable));
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public void warn(String s) {
        System.out.println("[WARN] " + formatTime() + s);
    }

    public void warn(String s, Object o) {
        System.out.println("[WARN] " + this.formatMessage(s, o));
    }

    public void warn(String s, Object... objects) {
        System.out.println("[WARN] " + this.formatMessage(s, objects));
    }

    public void warn(String s, Object o, Object o1) {
        System.out.println("[WARN] " + this.formatMessage(s, o, o1));
    }

    public void warn(String s, Throwable throwable) {
        System.out.println("[WARN] " + this.formatMessage(s, throwable));
    }

    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    public void warn(Marker marker, String s) {
        System.out.println("[WARN] " + formatTime() + s);
    }

    public void warn(Marker marker, String s, Object o) {
        System.out.println("[WARN] " + this.formatMessage(s, o));
    }

    public void warn(Marker marker, String s, Object o, Object o1) {
        System.out.println("[WARN] " + this.formatMessage(s, o, o1));
    }

    public void warn(Marker marker, String s, Object... objects) {
        System.out.println("[WARN] " + this.formatMessage(s, objects));
    }

    public void warn(Marker marker, String s, Throwable throwable) {
        System.out.println("[WARN] " + this.formatMessage(s, throwable));
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public void error(String s) {
        System.out.println("[ERROR] " + formatTime() + s);
    }

    public void error(String s, Object o) {
        System.out.println("[ERROR] " + this.formatMessage(s, o));
    }

    public void error(String s, Object o, Object o1) {
        System.out.println("[ERROR] " + this.formatMessage(s, o, o1));
    }

    public void error(String s, Object... objects) {
        System.out.println("[ERROR] " + this.formatMessage(s, objects));
    }

    public void error(String s, Throwable throwable) {
        System.out.println("[ERROR] " + this.formatMessage(s, throwable));
    }

    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    public void error(Marker marker, String s) {
        System.out.println("[ERROR] " + formatTime() + s);
    }

    public void error(Marker marker, String s, Object o) {
        System.out.println("[ERROR] " + this.formatMessage(s, o));
    }

    public void error(Marker marker, String s, Object o, Object o1) {
        System.out.println("[ERROR] " + this.formatMessage(s, o, o1));
    }

    public void error(Marker marker, String s, Object... objects) {
        System.out.println("[ERROR] " + this.formatMessage(s, objects));
    }

    public void error(Marker marker, String s, Throwable throwable) {
        System.out.println("[ERROR] " + this.formatMessage(s, throwable));
    }

    private String formatMessage(String input, Object... args) {
        return formatTime() + MessageFormatter.arrayFormat(input, args).getMessage();
    }

    private String formatMessage(String input, Throwable t, Object... args) {
        return formatTime() + MessageFormatter.arrayFormat(input, args, t).getMessage();
    }

    private String formatTime() {
        return "[" + new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())) + "] ";
    }
}
