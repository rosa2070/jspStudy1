package com.exam.album.board.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AlbumAction {
	public static String UPLOAD_PATH = "C:/Java/jsp-workspace/AlbumCMTModel2Ex01/src/main/webapp/upload";
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
