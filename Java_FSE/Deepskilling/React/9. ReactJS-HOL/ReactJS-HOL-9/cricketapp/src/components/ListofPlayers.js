function ListofPlayers({ players }) {

    return (

        <div>

            {
                players.map((item) => (

                    <p key={item.name}>
                        Mr. {item.name} <span>{item.score}</span>
                    </p>

                ))
            }

        </div>

    );

}

export default ListofPlayers;