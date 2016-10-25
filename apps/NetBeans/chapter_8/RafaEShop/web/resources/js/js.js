var i = 3;

function changeCategory(category){
    setCookie('page',0,1);
    setCookie('category',category,1);
}

function pagination(total){
    
    page = getCookie('page');
    nr_pages = Math.ceil(total/i);
    
    if(parseInt(page) == 0){
        document.getElementById("prevId").style.visibility="hidden";
    } else {
        document.getElementById("prevId").style.visibility="visible";
    }
    
    if(((parseInt(page)+1)<nr_pages)){
        document.getElementById("nextId").style.visibility="visible";
    } else {
        document.getElementById("nextId").style.visibility="hidden";
    }  
    
    document.getElementById("pageOfTotalId").innerHTML=(parseInt(page)+1) + " of " + nr_pages;
}

function nextPage(){
    page = getCookie('page');
    if(page != 'nocookie'){
        page=parseInt(page);
        page=page+1;
        setCookie('page',page,1);
    
        document.getElementById("pageFormId:pageFormBId").click();
    }
}


function previousPage(){
    page = getCookie('page');
    if((page != 'nocookie')&&(page>0)){
        page=parseInt(page);
        page=page-1;
        setCookie('page',page,1);
    
        document.getElementById("pageFormId:pageFormBId").click();
    }
}

function addToCart(id, sku, name, price){
   
    var size_id = id.substring(0,id.lastIndexOf(":")).concat(":sizeId_input");
    var color_id = id.substring(0,id.lastIndexOf(":")).concat(":colorId_input");
    var quantity_id = id.substring(0,id.lastIndexOf(":")).concat(":quantityId_input");

    var size_obj = document.getElementById(size_id);
    var color_obj = document.getElementById(color_id);
    var quantity_obj = document.getElementById(quantity_id);
    
    if((typeof(size_obj) != 'undefined' && size_obj != null) &&
        (typeof(color_obj) != 'undefined' && color_obj != null) &&
        (typeof(quantity_obj) != 'undefined' && quantity_obj != null))
        {
        var size_val = size_obj.options[size_obj.selectedIndex].text;
        var color_val = color_obj.options[color_obj.selectedIndex].text;
        var quantity_val = quantity_obj.options[quantity_obj.selectedIndex].text;
        
        document.getElementById("itemFormId:hiddenSkuId").value = sku;
        document.getElementById("itemFormId:hiddenNameId").value = name;
        document.getElementById("itemFormId:hiddenPriceId").value = price;
        document.getElementById("itemFormId:hiddenSizeId").value = size_val;
        document.getElementById("itemFormId:hiddenColorId").value = color_val;
        document.getElementById("itemFormId:hiddenQuantityId").value = quantity_val;
        
        document.getElementById("itemFormId:itemBtnId").click();
    }        
}

function clearCookies(){
    document.getElementById("pageOfTotalId").innerHTML="";
    document.getElementById("prevId").style.visibility="hidden";
    document.getElementById("nextId").style.visibility="hidden";
    
    deleteCookie('page');
    deleteCookie('category');
}

function setCookie(c_name,value,exdays)
{
    var exdate=new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
    document.cookie=c_name + "=" + c_value;
}

function deleteCookie(c_name) {
    document.cookie = encodeURIComponent(c_name) + "=deleted; expires=" + new Date(0).toUTCString();
}

function getCookie(c_name) {
    var i,x,y,ARRcookies=document.cookie.split(";");
    for (i=0;i<ARRcookies.length;i++)
    {
        x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
        y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
        x=x.replace(/^\s+|\s+$/g,"");
        if (x==c_name)
        {
            return unescape(y);
        }
    }
    return "nocookie";
}



