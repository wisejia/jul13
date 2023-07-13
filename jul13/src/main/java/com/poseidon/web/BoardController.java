package com.poseidon.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Ctrl + shift + o --> 임포트 정리해줘요.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	// 사용자가 /board라고 호출하면 동작할 메소드를 만들겠습니다.
	@GetMapping("/board")
	public ModelAndView board() {
		ModelAndView mv = new ModelAndView("board");// jsp파일명
		mv.addObject("name", "홍길동");

		List<BoardDTO> list = new ArrayList<BoardDTO>();
		for (int i = 1; i <= 10; i++) {
			BoardDTO e = new BoardDTO(i, i + "번째 글 입니다", "홍길동", "2023-07-" + i, i * 10);
			// e.setBno(i);
			// e.setBtitle(i + "번째 글 입니다");
			// e.setBwrite("홍길동");
			// e.setBdate("2023-07-" + i);
			// e.setBlike(i * 10);
			list.add(e);
		}

		mv.addObject("list", list);

		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

		for (int i = 1; i < 10; i++) {
			Map<String, Object> e = new HashMap<String, Object>();
			e.put("bno", i);
			e.put("btitle", i + "번째 글 입니다2");
			e.put("bwrite", "홍길동");
			e.put("bdate", "2023-07-13");
			e.put("blike", i * 10);
			list2.add(e);
		}

		mv.addObject("list2", list2);

		return mv;
	}
	
	@GetMapping("/board2")
	public String board2(Model model) {
		model.addAttribute("name", "홍길동");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		for (int i = 1; i < 11; i++) {
			BoardDTO dto = new BoardDTO(i, "제목입니다", "홍길동", "2023-07-13", i);
			list.add(dto);
		}
		
		model.addAttribute("list", list);
		
		return "board2";
	}
	
	
	
	
	
	
	
	
	
	
	

}
