function ListofIndianPlayers({ IndianPlayers }) {

    return (

        <div>

            {

                IndianPlayers.map((player, index) => (

                    <p key={index}>
                        Mr. {player}
                    </p>

                ))

            }

        </div>

    );

}

export default ListofIndianPlayers;