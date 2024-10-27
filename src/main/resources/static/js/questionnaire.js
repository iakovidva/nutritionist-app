
let currentStep = 1;
const totalSteps = 9;

function showStep(step) {
    document.querySelectorAll('.step').forEach((el) => el.classList.remove('active'));
    document.getElementById(`step-${step}`).classList.add('active');
}

function nextStep() {
    if (validateStep(currentStep)) {
        if (currentStep < totalSteps) {
            currentStep++;
            showStep(currentStep);
            updateProgressBar();
        }
    }
}

function previousStep() {
    if (currentStep > 1) {
        currentStep--;
        showStep(currentStep);
        updateProgressBar();
    }
}

function validateStep(stepNumber) {
    let isValid = true;

    // Get all input fields of the current step
    const step = document.getElementById('step-' + stepNumber);
    const inputs = step.querySelectorAll('input, select, textarea');

    // Loop through the inputs and validate
    inputs.forEach((input) => {
        if (!input.checkValidity()) {
            isValid = false;
            input.classList.add('is-invalid'); // Add Bootstrap class for invalid fields
        } else {
            input.classList.remove('is-invalid');
        }
    });
    return isValid;
}

// Initialize the first step
document.addEventListener("DOMContentLoaded", function() {
    showStep(currentStep);
    updateProgressBar();
});

function updateProgressBar() {
    const progress = (currentStep / totalSteps) * 100;
    const progressBar = document.querySelector('.progress-bar');
    progressBar.style.width = progress + '%';
    progressBar.setAttribute('aria-valuenow', currentStep);
}

document.addEventListener('DOMContentLoaded', function () {
    const hasAllergyOrIntolerance = document.getElementById('hasAllergyOrIntolerance');
    const allergiesOrIntolerancesDiv = document.getElementById('allergiesOrIntolerancesDiv');

    // Function to show or hide the allergy details
    function toggleAllergyDetails() {
        allergiesOrIntolerancesDiv.style.display = hasAllergyOrIntolerance.value === 'true' ? 'block' : 'none';
    }

    // Attach change event listener
    hasAllergyOrIntolerance.addEventListener('change', toggleAllergyDetails);

    // Initialize display state based on the initial value
    toggleAllergyDetails();
});

document.addEventListener('DOMContentLoaded', function () {
    const regularMenstrualCycle = document.getElementById('regularMenstrualCycle');
    const irregularCycleReasonDiv = document.getElementById('irregularCycleReasonDiv');

    // Function to show or hide the allergy details
    function toggleIrregularCycleReasonDiv() {
        irregularCycleReasonDiv.style.display = regularMenstrualCycle.value === 'false' ? 'block' : 'none';
    }

    // Attach change event listener
    regularMenstrualCycle.addEventListener('change', toggleIrregularCycleReasonDiv);

    // Initialize display state based on the initial value
    toggleIrregularCycleReasonDiv();
});


document.addEventListener('DOMContentLoaded', function () {
    const changesInAppetiteOrWeight = document.getElementById('changesInAppetiteOrWeight');
    const descriptionOfChangesDiv = document.getElementById('descriptionOfChangesDiv');

    // Function to show or hide the allergy details
    function toggleDescriptionOfChangesDiv() {
        descriptionOfChangesDiv.style.display = changesInAppetiteOrWeight.value === 'true' ? 'block' : 'none';
    }

    // Attach change event listener
    changesInAppetiteOrWeight.addEventListener('change', toggleDescriptionOfChangesDiv);

    // Initialize display state based on the initial value
    toggleDescriptionOfChangesDiv();
});