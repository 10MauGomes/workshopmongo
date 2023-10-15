package com.maugomes.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	public CommentDTO(String string, Date parse, Date date, AuthorDto authorDto) {
		
	}


	private static final long serialVersionUID = 1L;
	

	public class commentDTO{
		
		private String text;
		private Date date;
		private AuthorDto author;
		
		public commentDTO() {
		}

		public commentDTO(String text, Date date, AuthorDto author) {
			super();
			this.text = text;
			this.date = date;
			this.author = author;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public AuthorDto getAuthor() {
			return author;
		}

		public void setAuthor(AuthorDto author) {
			this.author = author;
		}
		
		
		
	}
	
	
	
	

}
