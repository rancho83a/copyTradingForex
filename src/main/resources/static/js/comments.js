const positionId = document.getElementById("positionId").value;
//console.log(positionId);

const commentCtnr = document.getElementById("commentCtnr");

const allComments = []

const displayComments = (comments) => {
commentCtnr.innerHTML = comments.map(c=> createCommentDom(c)).join('')
}

function createCommentDom(c) {
    let commentHtml = `<div id="commentCtnr-${c.id}">`
    commentHtml += `    <h4>    ${c.owner}  (${c.created})</h4>`
    commentHtml+= `<p> ${c.textContent}</p> </div>`;

    return commentHtml;
}

fetch(`http://localhost:8080/api/${positionId}/comments`)
.then(response=> response.json())
    .then(
        data=>{
            for (let comment of data){
                allComments.push(comment)
            }
            displayComments(data)
        }
    )
