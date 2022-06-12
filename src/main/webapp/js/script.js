const result = document.querySelector(".table-results");
const search = document.querySelector("#search");


let dataArray;

function getUsers(){
  console.log(JSON.parse(result.dataset.json))
  dataArray = orderList(JSON.parse(result.dataset.json))
  createUserList(dataArray)
}

getUsers();

function orderList(data) {

  const orderedData = data.sort((a,b) => {
    if(a.name.toLowerCase() < b.name.toLowerCase()) {
      return -1;
    }
    if(a.name.toLowerCase() > b.name.toLowerCase()) {
      return 1;
    }
    return 0;
  })
  
  return orderedData;
}



function createUserList(usersList) {

  usersList.forEach(user => {

    const listItem = document.createElement("a");
    listItem.setAttribute("class", "table-item");
    listItem.setAttribute("href", `/project-jee-school/GetUserServlet?id=${user.idPerson}`);

    listItem.innerHTML = `
    <div class="container-img">
    <img src="https://i.pravatar.cc/150?img=${user.idPerson}"/>
    <p class="name">${user.name}</p>
    </div>
    <p class="email">${user.email}</p>
    <p class="phone">${user.phone}</p>
    `
    result.appendChild(listItem);
  })
  
  
  
  
  
search.addEventListener("input", filterData)

function filterData(e) {

  result.innerHTML = ""

  const searchedString = e.target.value.toLowerCase().replace(/\s/g, "");

  const filteredArr = dataArray.filter(el => 
    el.name.toLowerCase().includes(searchedString) ||
    `${el.name.last + el.name.first}`.toLowerCase().replace(/\s/g, "").includes(searchedString)
    
    )

  createUserList(filteredArr)
}

}