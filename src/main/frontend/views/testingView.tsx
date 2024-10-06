import {ViewConfig} from '@vaadin/hilla-file-router/types.js';
import {MessageService} from 'Frontend/generated/endpoints.js';
import {ChangeEvent, useEffect, useState} from "react";
import DietaryPreferencesForm from "Frontend/themes/my-hilla-app/components/Questionnaire/DietaryPreferencesForm";

export const config: ViewConfig = {
    menu: {order: 5, icon: 'line-awesome/svg/globe-solid.svg'},
    title: 'Testing View',
};

export default function TestingView() {
    const [question, setQuestion] = useState<string>('');

    // Use useEffect to fetch data when the component mounts
    useEffect(() => {
        const fetchAvoidedFoods = async () => {
            try {
                const avoidedFoods = await MessageService.getAvoidedFoods();
                // Set the value to the question state
                setQuestion(avoidedFoods);
            } catch (error) {
                console.error('Error fetching avoided foods:', error);
            }
        };

        fetchAvoidedFoods(); // Call the function to fetch data
    }, []); // Empty dependency array means this runs once on component mount

    return (
        <>
            <section className="flex p-m gap-m items-end">

                <h1>Your Avoided Foods</h1>
                <p>{question}</p>

                <DietaryPreferencesForm dietType={''}
                                        onDietChange={function (event: ChangeEvent<HTMLSelectElement>): void {
                                            throw new Error('Function not implemented.');
                                        }}/>

            </section>
        </>
    );
}
