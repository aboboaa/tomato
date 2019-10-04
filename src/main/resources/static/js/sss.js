<script type="text/javascript">
       layui.use(['form','layer','jquery','element','laypage','form'],function(){
        var form = layui.form();
        window.layer = layui.layer;
        layedit = layui.layedit;
        window.jQuery = window.$ = layui.jquery;
        var element = layui.element(),form = layui.form();    
        layer.photos({
                photos: '#layer-photos-demo'
        ,anim: 5
        }); 
 
        $(document).ready(function(){
                //alert($(".comment_list").find(".comment")[0] == undefined);
               if($(".comment_list").find(".comment")[0] == undefined) {
                  $(".comment_add_or_last").html("暂无人评论");
               }
               $(document).on('click','.show_reply_list', function(){ 
                           
                            if($(this).closest('.comment').find(".reply_list").css("display") != "none") {
                                 $(this).closest('.comment').find(".show_remain_reply").css("display","none");
                                 $(this).html("查看回复");
                                 
                            }else {
                               $(this).closest('.comment').find(".show_remain_reply").css("display","block");
                                   $(this).html("收起回复");
                                   
                            }
                            $(this).closest('.comment').find(".reply_list").toggle(500);
                      
                     
                });
 
              $(document).on('click','.show_remain_reply', function(){
                      $(this).html("已显示全部回复");
                      //TODO发送数据
 
              });
              $(document).on('click','.comment_add_or_last', function(){
                        var getMoreComment = $(this);
                        //TODO如果获取的数据为零
                        getMoreComment.html("没有更多评论了");
              });
 
        });
 
               
        
 
         
 
      });
 
