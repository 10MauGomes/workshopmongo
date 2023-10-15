package com.maugomes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.maugomes.workshopmongo.domain.Post;
import com.maugomes.workshopmongo.domain.User;
import com.maugomes.workshopmongo.dto.AuthorDto;
import com.maugomes.workshopmongo.dto.CommentDTO;
import com.maugomes.workshopmongo.repository.PostRepository;
import com.maugomes.workshopmongo.repository.UserRepository;

public class Instantiation {
	
	public class instantiation implements CommandLineRunner{
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private PostRepository postrepository;
		

		@Override
		public void run(String... args) throws Exception {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			
			userRepository.deleteAll();
			postrepository.deleteAll();
			
			
			User yasmim = new User(null, "Yasmim", "yasmim@gmail.com");
			User maurilio = new User(null, "maurilio", "maurilio@gmail.com");
			User lara = new User(null, "lara", "lara@gmail.com");
			
			Post post1 = new Post(null, sdf.parse("17/03/2004"), "Até mais, Yasmim", "Irei trabalhar", new AuthorDto( yasmim));
			Post post2 = new Post(null, sdf.parse("10/12/2001"), "eu te amo, Yasmim", "Irei estudar", new AuthorDto (yasmim));
			
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("17/03/2004"), sdf.parse("17/03/2004"), new AuthorDto(yasmim));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("10/12/20011"), sdf.parse("17/03/2004"), new AuthorDto(yasmim));
		CommentDTO c3 = new CommentDTO("Boa viagem", sdf.parse("17/03/2004"), sdf.parse("17/03/2004"), new AuthorDto(yasmim));
		
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postrepository.saveAll(Arrays.asList(post1,post2));
		
			
			
			userRepository.save(yasmim);	
			
			
			
			
			
		}
		
	
	}

}
