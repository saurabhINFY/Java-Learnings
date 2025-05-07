package org.learnings.interviewExperience.dto;

import java.util.List;

/*
 * Order record
 */
public record Order(int orderId, List<Product> products, String date) {}