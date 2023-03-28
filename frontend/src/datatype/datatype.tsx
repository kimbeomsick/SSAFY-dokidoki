
//경매가 진행중인 물건
//경매 완료된 물건이랑 겹치지 않게 기본값을 설정해 주었다. 
export type Post = {
    auction_id: number;
    auction_title: string;
    product_name: string;
    category_name: string;
    meeting_place: string | "";
    offer_price: number;
    cur_price: number | 0;
    price_size: number | 0;
    remain_hours: number | 0;
    remain_minutes: number | 0;
    remain_seconds: number | 0;
    is_my_interest: boolean; 
    is_my_auction: boolean;
    auction_image_url: string;


    //정료된 옥션에 추가되는 데이터
    final_price?: number|-1;
    start_time:string|"00:00:00";
    end_tiem:string|"00:00:00";
    is_sold_out:boolean|false;
  };




  //경매가 종료된 물건
export type endPost =  {
  final_price: number;
  start_time: string;
  end_time: string;
  is_sold_out: boolean
}


 