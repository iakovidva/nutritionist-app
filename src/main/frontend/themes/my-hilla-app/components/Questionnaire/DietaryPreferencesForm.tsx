import React from 'react';
import { WeeklyFrequency } from '../common/Enums';

interface DietaryPreferencesFormProps {
    dietType: string;
    onDietChange: (event: React.ChangeEvent<HTMLSelectElement>) => void;
}

const DietaryPreferencesForm: React.FC<DietaryPreferencesFormProps> = ({ dietType, onDietChange }) => {
    return (
        <div>
            <label htmlFor="dietType">Diet Type</label>
            <select id="dietType" value={dietType} onChange={onDietChange}>
                <option value="BALANCED_DIET">Balanced Diet</option>
                <option value="VEGETARIAN">Vegetarian</option>
                <option value="VEGAN">Vegan</option>
            </select>

            <label htmlFor="alcoholFrequency">How often do you drink alcohol?</label>
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
