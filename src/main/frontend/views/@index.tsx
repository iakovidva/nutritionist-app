import {ViewConfig} from '@vaadin/hilla-file-router/types.js';
import {useSignal} from '@vaadin/hilla-react-signals';
import {Button} from '@vaadin/react-components/Button.js';
import {Notification} from '@vaadin/react-components/Notification.js';
import {TextField} from '@vaadin/react-components/TextField.js';
import {HelloWorldService, WorkoutService} from 'Frontend/generated/endpoints.js';
import {Grid, GridColumn} from "@vaadin/react-components";
import {useState} from "react";
import Workout from "Frontend/generated/com/example/application/model/Workout";

export const config: ViewConfig = {
    menu: {order: 0, icon: 'line-awesome/svg/globe-solid.svg'},
    title: 'Hello World',
};

export default function HelloWorldView() {
    const name = useSignal('');
    const [data, setData] = useState<Workout[]>();

    return (
            <section className="flex p-m gap-m items-end">

                <TextField
                    label="Your name"
                    onValueChanged={(e) => {
                        name.value = e.detail.value;
                    }}
                />
                <Button
                    onClick={async () => {
                        const serverResponse = await HelloWorldService.sayHello(name.value);
                        Notification.show(serverResponse);
                        setData([]);
                    }}
                >
                    Say hello
                </Button>
                <Button
                    onClick={async () => {
                        WorkoutService.createWorkout();
                    }}
                >
                    Create workout
                </Button>
                <Button
                    onClick={async () => {
                        WorkoutService.getWorks().then((data) => {
                            setData(data);
                        });
                    }}
                >
                    Say sotos
                </Button>

                <Grid className="flex-grow" items={data}>
                    <GridColumn path="name"/>
                    <GridColumn path="type"/>
                    <GridColumn path="duration_minutes" autoWidth/>
                    <GridColumn path="calories_burned"/>
                    <GridColumn path="workout_date"/>
                    <GridColumn path="created_at"/>
                    <GridColumn path="updated_at"/>
                </Grid>
            </section>
    );
}
