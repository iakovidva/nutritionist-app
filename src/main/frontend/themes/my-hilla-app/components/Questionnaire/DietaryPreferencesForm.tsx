import React from 'react';
import { WeeklyFrequency } from '../common/Enums';
import {InterfacesServicePaok} from "Frontend/generated/endpoints";
import DietaryPreferences from "Frontend/generated/com/example/application/model/questionnaire/DietaryPreferences";
import dietType from "Frontend/generated/com/example/application/model/questionnaire/DietaryPreferences/DietType";

interface DietaryPreferencesFormProps {
    dietType: string;
    onDietChange: (event: React.ChangeEvent<HTMLSelectElement>) => void;
    dietTypesEnum: any
}

const DietaryPreferencesForm: React.FC<DietaryPreferencesFormProps> = ({ dietType, onDietChange, dietTypesEnum }) => {

    const types = Object.keys(dietTypesEnum ||[]).map(key =>dietTypesEnum[key as any])

    return (
        <div>
            <label htmlFor="dietType">Diet Type</label>
            <select id="dietType" value={dietType} onChange={onDietChange}>
                {types.map(type=>{
                    return <option value={type}>{type}</option>
                })}
            </select>

            <label htmlFor="alcoholFrequency">How often do you drink alcohol? sotiri?</label>
            <select id="alcoholFrequency">
                {Object.values(WeeklyFrequency).map((frequency) => (
                    <option key={frequency} value={frequency}>
                        {frequency}
                    </option>
                ))}
            </select>
        </div>
    );
};
export default DietaryPreferencesForm;
