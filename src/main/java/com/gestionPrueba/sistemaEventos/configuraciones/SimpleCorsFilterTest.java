package com.gestionPrueba.sistemaEventos.configuraciones;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SimpleCorsFilterTest {

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private FilterChain mockFilterChain;

    private SimpleCorsFilter corsFilter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        corsFilter = new SimpleCorsFilter();
    }

    @Test
    public void testDoFilter() throws ServletException, IOException {
        // Arrange
        when(mockRequest.getHeader("origin")).thenReturn("http://example.com");

        // Act
        corsFilter.doFilter(mockRequest, mockResponse, mockFilterChain);

        // Assert
        verify(mockResponse).setHeader("Access-Control-Allow-Origin", "http://example.com");
        verify(mockResponse).setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        verify(mockResponse).setHeader("Access-Control-Max-Age", "3600");
        verify(mockResponse).setHeader("Access-Control-Allow-Headers", "*");
        verify(mockFilterChain).doFilter(mockRequest, mockResponse);
    }

    @Test
    public void testDoFilter_OptionsRequest() throws ServletException, IOException {
        // Arrange
        when(mockRequest.getMethod()).thenReturn("OPTIONS");

        // Act
        corsFilter.doFilter(mockRequest, mockResponse, mockFilterChain);

        // Assert
        verify(mockResponse).setStatus(HttpServletResponse.SC_OK);
    }
}