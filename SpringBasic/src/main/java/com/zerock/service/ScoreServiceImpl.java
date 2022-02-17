package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;

//@Component //잘됨
//@Component("scoreService") // 이름 집어 넣어도 잘됨
//@Repository //잘됨

// 다 잘되지만 정확히 누군지인지 구분 하기위해서 이름을 구분 한다.

@Service("scoreService") //해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션(이름이있어도 되고 없어도 된다.)  
public class ScoreServiceImpl implements ScoreService {
	
	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void ScoreSRegister(ScoreVO dao) {
		System.out.println("---------service 계층 ");
		System.out.println(dao.getName()); //검증!! 시험에 나와용 ㅎㅎ
		System.out.println(dao.getKor());
		System.out.println(dao.getEng());
		System.out.println(dao.getMath());
		
		list.add(dao);
		System.out.println(list.toString());
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {
		
		
		return list;
	}

	@Override
	public void scoreDelete(String number) {
		
		int num = Integer.parseInt(number);
		list.remove(num);

	}

}
