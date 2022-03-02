package com.zerock.board.command;

public class Criteria {
		//mysql , mariaDB 에서는 :select * from board by num desc limit ?,?
		//oracle : select * from (select rownum as rnum,num,writer from board
		//where ROWNUM <= ? ORDER BY num desc) where rnum >= ?; 

		private int pageNum; //페이지 번호 결정
		private int count; //몇개의 데이터를 리스트에 출력할지 결정
		
		public Criteria() {
			//최초 게시판에 진입할때 기본 값 1번 페이지, 10개 데이터 셋팅
			this.pageNum = 1;
			this.count = 10;
			
		}

		public Criteria(int pageNum, int count) {
			//전달 받은 매개 변수를 이용한 페이지 값 출력
			super();
			this.pageNum = pageNum;
			this.count = count;
		}
		
		//mysql , mariaD 에서는 limit X, count 구문의 X값을 구하는 메서드
 		public int getPageStart() {
 			return ((pageNum - 1) * count); //-> mysql , mariaD인 경우 
 			//return ((pageNum - 1) * count)+ 1; //oracle 인 경우  
 		}
 		//getter setter 생성

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getCount() {
			return count;
		}
		public int getCount_oracle() { //위 쿼리에 따라서는 첫번째 ? 의 값이 증가하기 때문에.. 
			return (pageNum * count);
		}

		public void setCount(int count) {
			this.count = count;
		}
 		
		
	 
}
