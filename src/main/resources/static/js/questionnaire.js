
let currentStep = 1;
const totalSteps = 9;

function showStep(step) {
    document.querySelectorAll('.step').forEach((el) => el.classList.remove('active'));
    document.getElementById(`step-${step}`).classList.add('active');
}

function nextStep() {
    if (currentStep < totalSteps) {
        currentStep++;
        showStep(currentStep);
        updateProgressBar();
    }
}

function previousStep() {
    if (currentStep > 1) {
        currentStep--;
        showStep(currentStep);
        updateProgressBar();
    }
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