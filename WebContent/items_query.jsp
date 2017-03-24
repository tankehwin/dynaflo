<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body oncontextmenu="return true;"><!-- stop right-click action -->

<script language=JavaScript>
// highlight results table row when clicked with jquery. This is called from the pagination buttons now instead of auto-loaded 
// as before, because after clicking any page number, the event was being listened to anymore. Calling it from the pagination buttons 
// each time it is clicked now forces the event listener to refresh itself and be ready to respond
function highlight() {
	$(document).ready(function(){	
	    $("#results tr").click(function(){
	    	var selected = $(this).hasClass("highlight");
	        $("#results tr").removeClass("highlight");
	        $("#results tr").children("#sellPriceVal").addClass("sellDefault");
	        
	        if(!selected){
	        	$(this).addClass("highlight");
	        	$(this).children("#sellPriceVal").removeClass("sellDefault");
	
	        }
	    }); 
	});
}

</script>

<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	String error = "";
	String importResults = "";
	String partNum = "";
	String brand = "";
	BrandModel pricingVariableObj = null;
	int colspan = 7;
	boolean ifIracExists = false;	
	

	DecimalFormat formatter = new DecimalFormat("###,###,###,###.00");

	ArrayList<ItemModel> result = new ArrayList<ItemModel>();
	if(action != null && action.equals("searchPart")) {
		partNum = request.getParameter("partnum");	

		
		brand = request.getParameter("brand");	
		pricingVariableObj = BrandManager.getObject(brand, conn);
		if(!partNum.trim().equals("")){		
			result = ItemManager.getObject(partNum.toUpperCase(), brand, conn);
		
		}
	}
	else if(action != null && action.equals("importData")) {
		Properties prop = new Properties();
		ServletContext servletContext = session.getServletContext();
		prop.load(new FileInputStream(servletContext.getRealPath("/global.properties")));	

		String tomcatLocation = prop.getProperty("tomcatLocation");
	    String fileName = request.getParameter("fileName");
	   	String filePath = tomcatLocation + "webapps/data/import.xls";
		if(!filePath.trim().equals("")){

			ExcelReader excelBook = new ExcelReader();
			try{
				int importCount = excelBook.ingestExcelFile(filePath, fileName, conn);
				if(importCount>0){
					importResults = new Integer(importCount).toString() + " items were imported.";
%>
<div id="dialog-message" title="Import Successful">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		<%=importResults %>
	</p>
</div>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
</script>
<%
				}
			}
			catch(Exception ex){
				importResults = ex.getMessage();
%>
<div id="dialog-message" title="Import Failed">
	<p>
		<span class="ui-icon ui-icon-notice" style="float:left; margin:0 7px 50px 0;"></span>
		<%=importResults %>
	</p>
</div>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
</script>
<%				
			}			
		}	
	}
	
%>
<form action="items_query.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="searchPart">
<table class="cleartable" >
	<tr>
		<td>
			<table class="gridtable" style="display:inline-block;table-layout:fixed;width:380px;">
				<col style="overflow:hidden;width:100px;" id="colSearchTitle"/>
				<col style="overflow:hidden;width:250px;" id="colSearchValue"/>
				<tr>
					<th colspan="2"><div style="overflow:hidden;">SEARCH PARTS</div>
					</th>
				</tr>
				<tr>
					<th><div class="criteria">BRAND:</div>
					</th>
					<td><div class="criteria">
						<select style="width:165px;" name="brand">
			<%
				ArrayList<BrandModel> brands = BrandManager.getAllObjects(conn);
				// trying out new style of for loop
				for(BrandModel brandObj : brands){
			%>
							<option value="<%=brandObj.getName() %>" <%=(brand.trim().equals(brandObj.getName()))?"selected":"" %>><%=brandObj.getName() %></option>
			<%
				}
			%>
						</select></div>
					</td>
				</tr>
				<tr>
					<th><div class="criteria">PART NO.:</div>
					</th>
					<td><div class="criteria"><input type="text" class="partNumber" name="partnum" value="<%=partNum %>" /><input type="submit" value="Search" /></div>
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table class="gridtable" style="display:inline-block;table-layout:fixed;width:250px;">
				<col style="overflow:hidden;width:120px;" id="colDoubleTitle"/>
				<col style="overflow:hidden;width:130px;" id="colDoubleValue"/>
				<tr>
					</td>
					<th><div class="criteria">FREIGHT:</div>
					</th>
					<td><div align="center" class="criteria"><%=(pricingVariableObj!=null)?pricingVariableObj.getFreightCharges():"" %></div>
					</td>
				</tr>
				<tr>
					<th><div class="criteria">PRICE DATE:</div>
					</th>
					<td colspan="3"><div align="center" class="criteria"><%=(pricingVariableObj!=null)?pricingVariableObj.getPriceDate():"" %></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<br />
<table id="spacerHeader" class="gridtable" style="table-layout:fixed;width:1230px;">
	<tr>
		<th colspan="<%=colspan%>">SEARCH RESULTS
		</th><!-- this is now separated from main table due to problems interacting with the pagination code, quick fix -->
	</tr>
</table>
<table id="results" class="gridtable" style="table-layout:fixed;width:1230px;">
	<col style="overflow:hidden;width:200px;" id="colPartNo"/>
	<col style="overflow:hidden;width:220px;" id="colDesc"/>
	<col style="overflow:hidden;width:220px;" id="colAddInfo1"/>
	<col style="overflow:hidden;width:220px;" id="colAddInfo2"/>
	<col style="overflow:hidden;width:220px;" id="colAddInfo3"/>
	<col style="overflow:hidden;width:100px;" id="colSellPrice"/>
	<col style="overflow:hidden;width:50px;" id="colDynDisCode"/>
	<tr>
		<th >PART NO.
		</th>
		<th >DESCRIPTION
		</th>
		<th >ADD. INFORMATION 1
		</th>
		<th >ADD. INFORMATION 2
		</th>
		<th >ADD. INFORMATION 3
		</th>		
		<th >SELLING PRICE<br/>(RM)
		</th>
		<th >DYN <br/>DISC. <br/>CODE
		</th>
	</tr>
<%
	for(int i=0; i<result.size(); i++){
		ItemModel itmObj = result.get(i);
		if(itmObj.getPartNumber().startsWith("IAV")){
			ifIracExists = true;
		}
%>
	<tr>
		<td><%=itmObj.getPartNumber() %>
		</td>
		<td><%=itmObj.getDescription() %>
		</td>
		<td><%=itmObj.getAddInfo1() %>
		</td>
		<td><%=itmObj.getAddInfo2() %>
		</td>
		<td><%=itmObj.getAddInfo3() %>
		</td>
		<td align="right" id="sellPriceVal" class="sellDefault"><%=(itmObj.getSellingPrice().longValue()==0)?"-":formatter.format(itmObj.getSellingPrice()) %>
		</td>
		<td align="center"><%=itmObj.getDynafloDiscountCode() %>
		</td>
	</tr>
<%		
	}
%>
</table>

<script>
/*      =================================
**      ==== Simple Table Controller ====
**      =================================
**
**
**          With Pure JavaScript .. 
**   
**
**      No Libraries or Frameworks needed!
**
**
**              fb.com/bastony
**  
*/



// get the table element
var $table = document.getElementById("results"),
// number of rows per page
$n = 15,
// number of rows of the table
$rowCount = $table.rows.length,
// get the first cell's tag name (in the first row)
$firstRow = $table.rows[0].firstElementChild.tagName,
// boolean var to check if table has a head row
$hasHead = ($firstRow === "TH"),
// an array to hold each row
$tr = [],
// loop counters, to start count from rows[1] (2nd row) if the first row has a head tag
$i,$ii,$j = ($hasHead)?1:0,
// holds the first row if it has a (<TH>) & nothing if (<TD>)
$th = ($hasHead?$table.rows[(0)].outerHTML:"");
// count the number of pages
var $pageCount = Math.ceil($rowCount / $n);
// if we had one page only, then we have nothing to do ..
if ($pageCount > 1) {
    // assign each row outHTML (tag name & innerHTML) to the array
    for ($i = $j,$ii = 0; $i < $rowCount; $i++, $ii++)
        $tr[$ii] = $table.rows[$i].outerHTML;
    // create a div block to hold the buttons
    $table.insertAdjacentHTML("afterend","<br/><div id='buttons'></div");
    // the first sort, default page is the first one
    sort(1);
}

// ($p) is the selected page number. it will be generated when a user clicks a button
function sort($p) {
    /* create ($rows) a variable to hold the group of rows
    ** to be displayed on the selected page,
    ** ($s) the start point .. the first row in each page, Do The Math
    */
    var $rows = $th,$s = (($n * $p)-$n);
    for ($i = $s; $i < ($s+$n) && $i < $tr.length; $i++)
        $rows += $tr[$i];
    
    // now the table has a processed group of rows ..
    $table.innerHTML = $rows;
    // create the pagination buttons
    document.getElementById("buttons").innerHTML = pageButtons($pageCount,$p);
    // CSS Stuff
    document.getElementById("id"+$p).setAttribute("class","active");
}


// ($pCount) : number of pages,($cur) : current page, the selected one ..
function pageButtons($pCount,$cur) {
    /* this variables will disable the "Prev" button on 1st page
       and "next" button on the last one */
    var $prevDis = ($cur == 1)?"disabled":"",
        $nextDis = ($cur == $pCount)?"disabled":"",
        /* this ($buttons) will hold every single button needed
        ** it will creates each button and sets the onclick attribute
        ** to the "sort" function with a special ($p) number..
        */
        $buttons = "<input type='button' value='&lt;&lt; Prev' onclick='sort("+($cur - 1)+")' "+$prevDis+">";
    for ($i=1; $i<=$pCount;$i++)
        $buttons += "<input type='button' id='id"+$i+"'value='"+$i+"' onclick='sort("+$i+")'>";
    $buttons += "<input type='button' value='Next &gt;&gt;' onclick='sort("+($cur + 1)+")' "+$nextDis+">";
    
    highlight(); // refreshes row-highlight event listener code
    
    return $buttons;
}
</script>

<%
	if(ifIracExists){
%>
<br/>
<table class="gridtable">
<tr>
<td>
<div>
NOTE : <br/>
- Eex models are equipped with electrical installation for potentially explosive atmospheres Group II, category 2G - suitable for Zone 1 <br/>
- Eex-d models are supplied with exploision proof electric system for fire and explosion dangerous areas Class 1 div 1 - suitable for Zone 1 <br/>
- ADT models are equipped with electrical installation for potentially explosive atmospheres Group II, Category 3G - suitable for Zone 2 <br/>
- All models come with SST (304) tanks <br/>
- All models come with diathermic oil  except AV150 XE & AV200 XE <br/>
- All models come with 1 x CLIPSAC bag clip and 3 x IRSAC thermoproof bags <br/>
- Thermoproof disposal bags are manufactured to withstand temperatures up to 200°C <br/>
</div>
</td>
</tr>
</table>
<%
	}
%>
</body>
<%@include file="includes/footer.jsp" %>   
</html>