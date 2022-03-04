 const voteButton = document.querySelector('.upvote-btn');

 //click handler function for upvote button
 async function upvoteClickHandler(event) {
    event.preventDefault();

    const id = window.location.toString().split('/')[
        window.location.toString().split('/').length - 1
    ];

    const response = await fetch('/posts/upvote', {
        method: 'PUT',
        body: JSON.stringify({
            postId: id
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    });

    if(response.ok) {
        document.location.reload();
    } else {
        alert(response.statusText);
    }
}

voteButton.addEventListener('click', upvoteClickHandler);