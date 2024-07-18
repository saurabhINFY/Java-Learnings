package org.learnings.streams.dto;

public record Tech(String name, int YOE) {

    @Override public String toString() {
        return "Tech{" + "name='" + name + '\'' + ", YOE=" + YOE + '}';
    }
}
